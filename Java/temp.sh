
javac ./*java
echo

java Caesar encrypt 3 "The ships hung in the sky in much the same way that bricks don't."
echo
java Caesar decrypt 3 "Wkh vklsv kxqj lq wkh vnb lq pxfk wkh vdph zdb wkdw eulfnv grq'w."
echo
java Caesar encrypt 3
echo
java Caesar encrypt 3 The ships hung in the sky in much the same way that bricks don\'t.
echo

java MonoAlphaSubstitution encrypt akbjcidhegffgehdicibka "Life is wasted on the living."
echo
java MonoAlphaSubstitution decrypt akbicidhegffgehdicibka "Lcfg cs wkstgh on tdg lbvbne."
echo
java MonoAlphaSubstitution decode akbjcidhegffgehdicjbka "Life is wasted on the living"
echo
java MonoAlphaSubstitution decrypt
echo
java MonoAlphaSubstitution encrypt akbjcidhegffgehdicjbka Life is wasted on the living.
echo

java Vigenere encrypt COMPONETWOTWO "fun fun fun"
echo
java Vigenere decrypt COMPONETWOTWO "hiz thr big"
echo
java Vigenere enc COMPONETWOTWO "fun fun fun"
echo
java Vigenere decrypt COMPONETWOTWO
echo
java Vigenere encrypt COMPONETWOTWO fun fun fun
echo
