# Jacob Wilkins

import re
import sys

def processToken(token) :

  idPattern1 = re.compile(r'^([$]|[|]|[a-z])[A-Z0-9]*$')
  idPattern2 = re.compile(r'^([|][A-Z0-9]*[|])$')
  intPattern = re.compile(r'^(%)([0-9]|[A-Fa-f])+$')
  fpPattern = re.compile(r'^[0-9]+[.][0-9]+$')

  idMatch1 = idPattern1.match(token)
  idMatch2 = idPattern2.match(token)
  intMatch = intPattern.match(token)
  fpMatch = fpPattern.match(token)

  if idMatch1:
    print('>%s< matches ID' % (token))
  elif idMatch2:
    print('>%s< matches ID' % (token))
  elif intMatch:
    print('>%s< matches INT' % (token))
  elif fpMatch:
    print('>%s< matches FP' % (token))
  else:
    print('>%s< does not match' % (token))

def main() :
  fName = sys.argv[1]
  print('processing tokens from ' + fName + ' ...')

  with open(fName, 'r') as fp :
    lines = fp.read().replace('\r', '').split('\n')

  for line in lines :
    for token in line.split() :
      processToken(token)

if (__name__ == '__main__') :
  main()
