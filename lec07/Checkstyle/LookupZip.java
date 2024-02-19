import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class LookupZip {
    /** Parses one line of input by creating a Place that
     * denotes the information in the given line
     * @param line One line from the zipcodes file
     * @return A Place that contains the relevant information
     * (zip code, town, state) from that line
     */
    public static ExpandableArray<Place> parseLine(String line, ExpandableArray<Place> places) {
        String[] values = line.split(",");
        String zip = values[0];
        String town = values[1];
        String state = values[2];

        boolean isPopulated = false;
        if (values.length > 3) {
            isPopulated = true;
        }

        for (int i=0; i<places.size(); i++) {
            if (places.get(i).getZip().equals(zip)) {
                if (isPopulated) {
                    String population = values[3];
                    LocatedPlace locatedPlace = (LocatedPlace) places.get(i);
                    double longitude = locatedPlace.getLongitude();
                    Place p = 
                        new PopulatedPlace(zip, town, state, longitude, locatedPlace.getLatitude(), Integer.valueOf(population));

                    places.set(p, i);
                } 
                return places;
            }
        }

        places.insert(new Place(zip, town, state), places.size());

        return places;
    }

    public static Place parseLine2(String line) {
        String[] values = line.split(",");
        String zip = values[0].replace("\"","");
        String rawTown = values[2].replace("\"","");
        String[] townWords = rawTown.split(" ");
        String town = "";
        for (int i=0; i<townWords.length; i++) {
            if (i > 0) {
                town += " ";
            }
            town += townWords[i].substring(0, 1).toUpperCase() + townWords[i].substring(1).toLowerCase();
        }
        String state = values[3].replace("\"","");

        if(values[5].equals("")) {
            return new Place(zip, town, state);

        } else {

            double latitude = Double.parseDouble(values[5]);
            double longitude = Double.parseDouble(values[6]);

            return new LocatedPlace(zip, town, state, latitude, longitude);
        }
    }


    /** Reads a zipcodes file, parsing every line
     * @param filename The name of the zipcodes file
     * @param numEntries the number of places in the csv file
     * @return The array of Places representing all the
     * data in the file.
     */
    public static ExpandableArray<Place> readZipCodes(String filename, String filename2) throws FileNotFoundException {
        ExpandableArray<Place> places = new ExpandableArray<Place>();
        Scanner sc = new Scanner(new File(filename2));
        sc.nextLine(); //first line
        int i = 0;
        while (sc.hasNextLine()) {
            Place p = parseLine2(sc.nextLine());
            places.insert(p, i);
            i += 1;
        }

        Scanner sc2 = new Scanner(new File(filename));
        sc2.nextLine(); //first line
        while (sc2.hasNextLine()) {
            places = parseLine(sc2.nextLine(), places);
        }

        return places;
    }


    /** Find a Place with a given zip code
     * @param places The array of Place objects to search through
     * @param zip The zip code (as a String) to look up
     * @return A place that matches the given zip code,
     * or null if no such place exists.
     */
    public static Place lookupZip(ExpandableArray<Place> places, String zip) {
        for(int i = 0; i < places.size(); i++) {
            if (places.get(i).getZip().equals(zip)) {
                return places.get(i);
            }
        }      

        return null;
    }
}




