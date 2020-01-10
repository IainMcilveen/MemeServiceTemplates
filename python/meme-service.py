import requests
import json
url = 'https://memeservice.cfapps.io/api/memes'

response = requests.get(url)

memeArray = json.loads(response.text)

print(memeArray[0])