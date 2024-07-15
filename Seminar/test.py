from datetime import datetime
dateTime = datetime.now()

with open('test.txt', 'a') as f:
	f.write(str(dateTime))
	f.write('\n')
