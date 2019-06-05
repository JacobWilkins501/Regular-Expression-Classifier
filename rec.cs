/*H****************************************************************
* FILENAME :        rec.cs
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
*       Copyright 2017, Jacob Wilkins.  All rights reserved.
* 
* AUTHOR :    Jacob Wilkins        START DATE :    24 Sep 18
*
*H*/

using System;
using System.IO;
using System.Text.RegularExpressions;

public class rec
{
  static public void processToken( string token ) {

    Regex idPattern1 = new Regex(@"^([$]|[|]|[a-z])[A-Z0-9]*$", RegexOptions.Compiled);
    Regex idPattern2 = new Regex(@"^([|][A-Z0-9]*[|])$", RegexOptions.Compiled);
    Regex intPattern = new Regex(@"^(%)([0-9]|[A-Fa-f])+$", RegexOptions.Compiled);
    Regex fpPattern = new Regex(@"^[0-9]+[.][0-9]+$", RegexOptions.Compiled);
    
    Match idMatch1 = idPattern1.Match(token);
    Match idMatch2 = idPattern2.Match(token);
    Match intMatch = intPattern.Match(token);
    Match fpMatch = fpPattern.Match(token);

    if (idMatch1.Success) {
      Console.WriteLine(">" + token + "< matches ID");
    } else if (idMatch2.Success) {
      Console.WriteLine(">" + token + "< matches ID");
    } else if (intMatch.Success) {
      Console.WriteLine(">" + token + "< matches INT");
    } else if (fpMatch.Success) {
      Console.WriteLine(">" + token + "< matches FP");
    } else {
      Console.WriteLine(">" + token + "< does not match");
    }

  }

  static public void Main( string[] args )
  {
    Console.WriteLine( "processing tokens from " + args[ 0 ] + " ..." );

    foreach ( string line in File.ReadAllLines( args[ 0 ] ) ) {
      foreach ( string token in line.Split( (char []) null, StringSplitOptions.RemoveEmptyEntries ) ) {
        processToken( token );
      }
    }
  }
}
