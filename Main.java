import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>(new idComparator());
        HashMap<Integer, String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                int id = Integer.parseInt(parts[0]);
                String verse = parts[1];
                hashMap.put(id, verse);
                arrayList.add(line);
                treeSet.add(line);
                hashSet.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("poemArrayList.txt");
            for (String verse : arrayList) {
                writer.write(verse + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("poemArrayListOrderByID.txt");
            Collections.sort(arrayList, new idComparator());
            for (String verse : arrayList) {
                writer.write(verse + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("poemHashSet.txt");
            for (String verse : hashSet) {
                writer.write(verse + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("poemTreeSet.txt");
            for (String verse : treeSet) {
                writer.write(verse + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("poemTreeSetOrderByID.txt");
            for (String verse : treeSet) {
                writer.write(verse + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("poemHashMap.txt");
            for (int id : hashMap.keySet()) {
                String verse = hashMap.get(id);
                writer.write(id + "\t" + verse + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}

class idComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] parts1 = s1.split("\t");
        String[] parts2 = s2.split("\t");
        int id1 = Integer.parseInt(parts1[0]);
        int id2 = Integer.parseInt(parts2[0]);
        return Integer.compare(id1, id2);
    }
}
