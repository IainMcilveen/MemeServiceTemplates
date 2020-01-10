// Welcome, fellow human! Below is some starter Javascript code
// to help you on your way to getting the list of memes and
// then posting your answers to the challenges.
//
// To run the application, you can either (1) open the index.html file in your favourite
// browser (JK, open it in Chrome), or, (2) use your trusty terminal application
// to navigate to this directory, execute `npm install`, and then `npm start`.
// This will start a local server at http://localhost:8080
//
// To view information about the structure of the requests or
// the schema of a <Meme>, go to https://app.swaggerhub.com/apis/rbc-cusec/meme-service

const MEME_SERVICE_URL = 'https://memeservice.cfapps.io/api';
const STUDENT_NAME = ''; // Set this value to your name
const STUDENT_EMAIL = ''; // Set this value to your email

////////////////////////////////////////////////////////////////////////////
// Starter Functions
////////////////////////////////////////////////////////////////////////////

getMemeList().then((memes) => {
  console.log(memes);
  // submitFilterChallenge(memes);
  // submitMinChallenge(memes);
  // submitSumChallenge(memes);
});

function submitFilterChallenge(memes) {
  // Do some magic

  // Submit your answer

}

function submitMinChallenge(memes) {
  // Do some magic

  // Submit your answer

}

function submitSumChallenge(memes) {
  // Do some magic

  // Submit your answer

}


////////////////////////////////////////////////////////////////////////////
// Helper Functions
////////////////////////////////////////////////////////////////////////////

// GET
// @description Gets the list of memes.
// @returns <Promise>

async function getMemeList() {
  let response = await fetch(`${MEME_SERVICE_URL}/memes`);
  let data = await response.json();
  return data;
}
