#!/bin/bash

B=$(awk '{printf("\\n%s", $0)}' $1 )

cat Count1
echo -n $A$B$C
cat Count2