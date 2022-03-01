# SpringBoot-CoronaTracker
A quick web page made with basic HTML, CSS and Bootstrap magic.
The REST api used is SpringBoot. I request the link for the raw data csv file from the link below. After creating a request and client, i run the string of data through a csvBodyReader and seperate the data using the three keywords: Country_region, Province-state and Admin2.

Admin2 is the County for the data set. Example: USA, Georgia, Cherokee.

After the csv has been parsed, I seperate the data using a list called allStats which holds ever state in the USA and ever county in each state. Another list is created but first converted to a HashSet in orer to eliminate the duplicates. This hashset is called USAstates which holds all unique states. once sorted it is then reconverted into a list and presented for the dropdown menu in the HTML.


Using the Covid-19 Tracking Data provided by https://github.com/CSSEGISandData/COVID-19 
Screenshot: ![Screen Shot 2022-03-01 at 4 22 38 PM](https://user-images.githubusercontent.com/46929938/156251080-9acb100b-f97c-41b2-9529-07a4bba39354.png)
