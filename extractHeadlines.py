rom urllib import urlopen
from bs4 import BeautifulSoup
import pymysql.cursors

news = []
link= []
# Webpage connection
url = "http://english.onlinekhabar.com/"
html = urlopen(url)
soup = BeautifulSoup(html, 'lxml')
rows=soup.find_all("div", "justin-news")

for row in rows:
    row_td = row.find_all('a')
    str_cells = str(row_td)
    cleantext = BeautifulSoup(str_cells, "lxml")
    news.append(cleantext.get_text())
    
    
    
for row in rows:
    row_td = row.find_all('a')
    str_cells = str(row_td)
    cleantext = BeautifulSoup(str_cells, "lxml")
    g=cleantext.find_all('a')    
    for e in g:
        link.append(e.get('href'))    
    

"""CREATE TABLE `headlines` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `news` varchar(255) ,
    `link` varchar(255),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
AUTO_INCREMENT=1 ;

"""
i=0
connection = pymysql.connect(host='localhost',
                             user='root',
                             password='',
                             db='testdb',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)

try:
    with connection.cursor() as cursor:
        while i < len(news):
            news = news[i]
            link = link[i]
            sql = "INSERT INTO `headlines` (`news`, `link`) VALUES (%s, %s)"
            cursor.execute(sql, (news, link))
            i=i+1
    connection.commit()
finally:
    connection.close()