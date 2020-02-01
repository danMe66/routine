from bs4 import BeautifulSoup
import requests

url = 'https://yegking.com/member/me/courses'
wb_date = requests.get(url)
soup = BeautifulSoup(wb_date.text,'lxml')
print(soup)
