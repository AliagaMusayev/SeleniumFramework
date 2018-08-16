For using this framework simply just do following steps
1. Create instance of generic BaseClass and then use all methods of this framework
For example:
 WebDriver _driver = new FirefoxDriver();
BaseClass<FirefoxDriver> myBase = new BaseClass(_driver);

2. Create your own Base Class (name of class can be anything) in your project, and then do implementation from IBaseClass interface
   and implement all methods of interface and write your own logic for methods

Note: If you choose 1st way, there already wroted logic of methods and ready for use.
Also you can extend BaseClass and override all methods and again you can modify working logic of methods