import sys
import os
import json
success=[]
failed=[]

#read the json file 
jsonData = json.load(open('data.json'))


#for each package 
for key in jsonData["Dependencies"] :
	print key + "   package installing.....";
	#install each package and store the stdout in data.txt
        os.system("pip install "+key+"=="+jsonData["Dependencies"][key]+"  > stdout.txt")
	#to check whether the package installed success or failure
        identify=0;
	#read the stdout 
        for line in open("stdout.txt" , "r") :
            wordArray=line.split(" ");
            i=0;	
            #following two cases are the successfull installation of package else package is not installed		
            for word in wordArray :
                if word == "Requirement" and wordArray[i+1] == "already" and wordArray[i+2] == "satisfied" :
                    identify=1;    
                    success.append(key);
                    break;
                elif word== "Successfully" and wordArray[i+1] == "installed" :
                    identify=1;    
                    success.append(key);
                    break;
                i=i+1;
	#if none of the above keyword is not matched then it is failed package
        if identify == 0 :
		#create new file with the package name 
		f = open(key+".txt","w")
		#write the output of stdout to newly created file
        	f.write( str(open("stdout.txt", "r" ).readlines() ) );
		#failed package names
		failed.append(key);

#if all packages are installed print success
if len(jsonData["Dependencies"]) == len(success) :
	print "success";
else :
	print "Successfully Installed packages are : " , success;

#To print the failed packages
if len(failed) !=0 :
	print "failed packages are :" + failed;
        
    


    



