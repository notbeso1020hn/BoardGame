# **MATCHING GAME**
Basic pieces of a version of Matching Game:

NOTE:

`Card`: JButton will hold int and Boolean for checking 
boolean false if the card is not matched.

`Display`: will have 5 instance variables

Timer(t) for delay after the match is wrong

Card(c1) and Card(c2) to keep tracking

Card(selectedCard) for open the card

method `checkCard`: will compare the value of the card

if matched, will unable the button

if not, will set back to original state of card

method `doTurn`: will reveal the value of card

save selected card to c1 and c2
method 

`won`: will check through the whole card

if one of them is false( not matched yet), will not trigger event
pop up congratz window.

`Main`: the JFrame that owns Display