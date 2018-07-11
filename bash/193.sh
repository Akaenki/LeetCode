# awk
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt

# sed
sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file.txt

# grep 
grep '^\([0-9]\{3\}|([0-9]\{3\}) \)[0-9]\{3\}-[0-9]\{4\}$' file.txt
