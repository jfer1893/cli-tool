# CLI Tool

CLI Tool is a command-line interface for fetching URLs from configured websites and checking their availability.

# Installation instructions
To install Cli Tool, Unzip the project sent by email. 
Inside the application folder open a Powershell window and type the following docker commands:

docker-compose up -d --build
 - This Command will create an image of our cli-tool and mount a volume to save and manage storage for this container.

After the build you should execute the following command:

docker run -it clitool-image

The Cli-Tool will start.
A message with the following text will appear "Please provide command".


## USAGE
Cli-Tool supports the following commands:

- fetch: Fetch URLs from configured websites. 

- live: Continuously query URLs based on an interval.

- history: Display data gathered in the datastore.

- backup: Create a backup of data in the datastore.

- restore: Restore data from a backup file into the datastore.

- exit: Application will be terminated.

The data will be stored in the volume configured in the docker-compose file provided.

### FETCH
fetch: this command will fetch URLS from a configured websites  and save it to a file named "urls.txt"
	
	Options:
		This Command has 2 optional arguments.
	output: Shows the result if the url is available or not.
	siteList: A list of urls separated by a space to fetch the availability of the URL.
	
	- Arguments 
	 - argument1: output
	 - argument2: list of URLs
	
		Examples:
	"fetch" -> will get the urls configured in the app and save to a file named "urls.txt"
	"fetch output" -> will get the urls configured in the app and save to a file named "urls.txt" and show it in the console
	"fetch output https:\\www.example.com" -> will get the urls configured in the app and add to the list the URL provided. The result of the site is available or not will be saved in the file "urls.txt" and shown in the console.
	
	Example of Output:
	https://www.google.pt/ - true
	https://www.mercedes-benz.io/ - true
	http://thissitedoesnotexits.xpto - false
	
### LIVE
Continuously query URLs based on an interval - for a demo propose it's configured for 5 requests in an interval of 5 seconds each!
	
	Options: 
	   This command has 2 optional arguments
	output:  
		Shows the result if the url is available or not
	siteList: 
		A list of urls separated by a space to fetch the availability of the URL
	
	Arguments 
	argument1: output
	argument2: list of URLs
	
	Examples:
	"live"
		Continuously query URLs based on an interval - for a demo propose it's configured for 5 requests in an interval of 5 seconds each! 
		it will continuously get the urls configured in the app and save to a file named "urls.txt"	
	"live output"
		Continuously query URLs based in the intervald defined
		it will continuously get the urls configured in the app and save to a file named "urls.txt" and show it in the console
	"live output https:\\www.example.com" 
		will get the urls configured in the app and add to the list the URL provided 
		it will be stored to a file named "urls.txt" and show it in the console.

### HISTORY
Display data gathered in the datastore.
	
	Options:
		This command has 1 optinal argument
	output:  
		Shows the result stored of the urls.txt file
	Arguments 
		argument1: url
	
	Examples:
	"history"
		Will show all the results stored in urls.txt file 
	"history www.google.pt"
		Will show the results stored in urls.txt file for the provided url in this case for: www.google.pt

### BACKUP
backup: Create a backup of data in the datastore.
	
	Options:
		This command has 1 mandatory argument
	output:  
		Takes a file path argument and creates a backup of data in current data store.
	Arguments 
		argument1: filePath
	
	Examples:
	"backup test.txt"
		It will copy the urls.txt file to test.txt 
	"backup"
		It will show a message "Please provide a file path for backup."

### RESTORE

 Restore data from a backup file into the datastore.
	
	Options:
		This command has 1 mandatory argument
	output:  
		Takes a file path argument and restore and merge the information in file provided in current data store.
	Arguments 
		argument1: filePath
	
	Examples:
	"restore test.txt"
		It will merge the test.txt content into urls.txt	
	"restore notExists.txt"
		The application will validate the file does not exists and show a message saying: "Invalid restore file: File does not exist invalid extension"
	"restore"
		It will show a message "Please provide a file path for restore."

### EXIT
The application will exit!

Thank you.