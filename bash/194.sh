awk '
{
  for(i=0;i<=NF;++i){
    if(w[i]==""){
      w[i]=$i;
    }else{
      w[i]=w[i]" "$i;
    }
  }
} 
END {
   for(i=1;i<=NF;++i){
     print w[i];
   }
}' file.txt 

