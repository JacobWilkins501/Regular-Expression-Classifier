Author: Jacob Wilkins
Language: C#, Java, Python (program is written in three languages, each running on it's own)

# Regular-Expression-Classifier

Classifies regular expressions as either an ID, INT, FP, or "Does not match".

### ID definition

- Starts with a dollar sign, a lowercase letter, or a vertical bar
- After the first character, any number (including zero) of uppercase letters and decimal digits
- If it starts with a vertical bar, it must end with a vertical bar as the last character

### INT definition

- Percent sign
- Followed by one or more hexidecimal digits
- Upper and lower case letters acceptable

### F{ definition

 - One or more decimal digits
 - Followed by a decimal point
 - followed by one or more decimal digits
 
 ##### Acceptable: 
 
 123.456
 
 0.1
 
 3.14159
 
 ##### Unacceptable:
 
 .123
 
 456.
 
 3456
