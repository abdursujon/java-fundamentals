public class StringBuilders {

  public static void hobby(String[] hobbyNames) {
    // combine all string together using StringBuilder
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < hobbyNames.length; i++) {
      sb.append(hobbyNames[i]);
      sb.append(" ");
    }

    sb.insert(sb.length(), "Music");

    if (sb.substring(0, 8).equals("Football")) {
      sb.replace(0, 8, "Chess");
    }

    System.out.print(sb + " \n");
  }

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("I");

    sb.append(" LOVE COFFEE");
    System.out.println(sb);

    sb.insert(6, " CAT AND");
    System.out.println(sb);

    System.out.println("Character at index 5 is: " + sb.charAt(5));

    sb.delete(7, 15);
    System.out.println(sb);

    sb.deleteCharAt(0);
    System.out.println(sb);

    sb.replace(6, 12, "FOOTBALL");
    System.out.println(sb);

    System.out.println("Length of string builder is " + sb.length());

    System.out.println("Substring of string builder is " + sb.substring(0, 6));

    System.out.println("Index of FOOTBALL is: " + sb.indexOf("FOOTBALL"));

    sb.ensureCapacity(200);

    System.out.println("Capacity of string buffer here is: " + sb.capacity());

    String myHobby = sb.toString();
    System.out.println(myHobby);

    System.out.println("Reverse of lOVE FOOTBALL :  " + sb.reverse());

    hobby(new String[] {"Football", "Cricket", "Hiking"});
  }
}
