/*H****************************************************************
* FILENAME :        rec.java
*
* DESCRIPTION :
*       Classifies text using defined regular expressions 
*
* PUBLIC FUNCTIONS :
*       int     processToken( string )
*
* NOTES :
*       This function uses specific critera to classify
*       Criteria described in README.md
*
*       Copyright 2018, Jacob Wilkins.  All rights reserved.
* 
* AUTHOR :    Jacob Wilkins        START DATE :    24 Sep 18
*
*H*/

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.*;

public class rec {
  public static void processToken( String token )
  {
    String idPattern1 = "^([$]|[|]|[a-z])[A-Z0-9]*$";
    String idPattern2 = "^([|][A-Z0-9]*[|])$";
    String intPattern = "^(%)([0-9]|[A-Fa-f])+$";
    String fpPattern = "^[0-9]+[.][0-9]+$";

    Pattern idRegex1 = Pattern.compile(idPattern1);
    Pattern idRegex2 = Pattern.compile(idPattern2);
    Pattern intRegex = Pattern.compile(intPattern);
    Pattern fpRegex = Pattern.compile(fpPattern);

    Matcher idMatcher1 = idRegex1.matcher(token);
    Matcher idMatcher2 = idRegex2.matcher(token);
    Matcher intMatcher = intRegex.matcher(token);
    Matcher fpMatcher = fpRegex.matcher(token);

    if (idMatcher1.matches()) {
      System.out.println(">" + token + "< matches ID");
    } else if (idMatcher2.matches()) {
      System.out.println(">" + token + "< matches ID");
    } else if (intMatcher.matches()) {
      System.out.println(">" + token + "< matches INT");
    } else if (fpMatcher.matches()) {
      System.out.println(">" + token + "< matches FP");
    } else {
      System.out.println(">" + token + "< does not match");
    }

  }

  public static void main( String[] args )
  {
    System.out.println( "processing tokens from " + args[ 0 ] + " ..." );

    try {
      Files.lines( Paths.get( args[ 0 ] ) ).forEachOrdered(
        line -> Arrays.stream( line.split( "\\s+" )  )
            .forEachOrdered( token -> processToken( token ) ) );
    } catch ( java.io.IOException e ) {
      e.printStackTrace();
    }
  }
}
