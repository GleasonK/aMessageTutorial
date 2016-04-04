# aMessage
## Send and receive texts from your laptop!

![cover_img](http://kevingleason.me/aMessage/assets/img/aMessage2.png)

## About

Android app that allows you to send and receive texts from your laptop. Built with [PubNub](https://www.pubnub.com/). Web front-end written in AngularJS.

## To Use

To get started using aMessage, follow the instructions to [download the APK here](http://kevingleason.me/aMessage/get.html). 

- Start and install the app on your phone and create a cipher and authkey. 
- Tap the button reading "disabled" to enable the service.
- Navigate from any browser to [http://kevingleason.me/aMessage](http://kevingleason.me/aMessage) to login and begin sending and receiving texts!

## Make it your own

Clone master and gh-pages branch. To use app, register for a [free PubNub account](https://admin.pubnub.com/#/register). Replace the values in `Config.java` to be your Pub/Sub/Secret Keys. 

Then, in the gh-pages branch, open `src/messaging/MessageController.js` and replace the pubnub values with your Pub/Sub/Secret Keys. Do the same for `src/messaging/MessageService.js`

## Tutorial

__Tutorial Coming Soon__