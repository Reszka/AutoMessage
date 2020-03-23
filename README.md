# AutoMessage
Functionality allows you to send message on Tidio chat and then confirm receiving it by chat's administrator. 

Code was wrote in IntelliJ IDEA using Java and programs supporting test automation such as Selenium and Cucumber.

<font size=18><b>IMPORTANT:</b></font>

To run this scenario you will need Chrome browser and chromedriver, which you can get <a href="https://chromedriver.storage.googleapis.com/index.html?path=80.0.3987.106/">here</a>. Path to chromedriver.exe used in this test is C:\\chromedriver.exe, but you can change it to a different file.

Please be aware that <i>[1585001917.349][SEVERE]: Timed out receiving message from renderer: 0.100</i> error, that could be shown in the logs is a Selenium bug, and has not yet been fixed. It may be handle by downgrade Chrome version to 79.0.3945.36.
