import sys

os = str(sys.argv[1])
bsapp = str(sys.argv[2])

#Open config file for mobile tests
with open('config.properties', 'r', encoding='utf-8') as file: 
    data = file.readlines() 

#Verify which os is on and if the bsapp string is correct format lenght 
if(os == "ios" and len(bsapp) == 45):
    data[17] = "IOS_APP_URL=" + bsapp + "\n"
    print("ios bsapp updated succesfully")
    
if(os == "android" and len(bsapp) == 45):
    data[16] = "ANDROID_APP_URL=" + bsapp + "\n"
    print("android bsapp updated succesfully")
    
#Rewrite with the new information
with open('test.config', 'w', encoding='utf-8') as file: 
    file.writelines(data) 