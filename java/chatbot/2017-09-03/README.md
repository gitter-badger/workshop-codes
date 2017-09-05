# Facebook chatbot workshop ( on 3 Sept, 2017 )

Here are noted links and steps for creating facebook chatbot with `Spting Boot`

* [Setup the pretext.]()
* Create Facebook app at developer account.
* [Set up development environment]()
* Create project with [Spring Initializr](http://start.spring.io/), add `Web` to dependencies.
* Generate a gradle project.
* Download and extract.
* open with idea and sync gradle.
* [Setup Git and Heroku]()
* [Add project to Heroku]()
* Add `Get` controller mapping to `\webhook` for verification.
* [Deploy to Heroku.]()
* Add `Webhook` product from Facebook dev app created. 
* Set callback url and token.
* Add `POST` controller mapping to `\webhook` to retrive messages. Compact json is [here]()
* Create RestTemplate to send messages through messanger product.
