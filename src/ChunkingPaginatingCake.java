import java.util.ArrayList;
import java.util.List;

public class ChunkingPaginatingCake {

    public static void main(String[] args) {
        // Sample list of data (slices of strawberry cake)
        List<String> cakeSlices = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            cakeSlices.add("Slice " + i);
        }

        // Number of slices per cake (page size)
        int slicesPerCake = 10;

        // Chunking and pagination
        int currentCake = 1;
        int totalSlices = cakeSlices.size();
        int totalCakes = (int) Math.ceil((double) totalSlices / slicesPerCake);

        while (currentCake <= totalCakes) {
            System.out.println("Cake " + currentCake + ":");
            List<String> currentCakeSlices = getSlicesForCake(cakeSlices, currentCake, slicesPerCake);
            displaySlices(currentCakeSlices);
            System.out.println("\n");

            if (currentCake % 10 == 0 && currentCake < totalCakes) {
                System.out.println("Please control yourself.\n");
            }

            currentCake++;
        }
    }

    // Method to get slices for a specific cake (page)
    private static List<String> getSlicesForCake(List<String> cakeSlices, int currentCake, int slicesPerCake) {
        int startIndex = (currentCake - 1) * slicesPerCake;
        int endIndex = Math.min(startIndex + slicesPerCake, cakeSlices.size());
        return cakeSlices.subList(startIndex, endIndex);
    }

    // Method to display slices of cake on a page
    private static void displaySlices(List<String> currentCakeSlices) {
        for (String slice : currentCakeSlices) {
            System.out.println(slice);
        }
    }
}
