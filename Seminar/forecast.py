# https://pypi.org/project/python-weather/
# import the module
import python_weather

import asyncio
import os
import pandas as pd


async def getweather():
  # declare the client. the measuring unit used defaults to the metric system (celcius, km/h, etc.)
  async with python_weather.Client(unit=python_weather.IMPERIAL) as client:
    # fetch a weather forecast from a city
    weather = await client.get('Fairbanks')
    
    # Create drectory to store forecast data
    forecast_dir = None

    # get the weather forecast for a few days
    for daily in weather.daily_forecasts:

        # Make folder to hold weather forecast for the current day.
        if forecast_dir == None:
          forecast_dir = str(daily.date)
          if not os.path.exists(str(daily.date)):
            os.makedirs(str(daily.date))

        # Define filename to save daily forecasts.
        forecast_csv = forecast_dir + '/' + str(daily.date) + '.csv'
        print(forecast_csv)

        # Make arrays to hold distinct series of data.
        temp = []
        time = []
        humidity = []
        chance_rain = []
        cloud_coverage = []
        # heat_index = []

        # hourly forecasts
        for hourly in daily.hourly_forecasts:
            print(f' --> {hourly!r}')

            temp.append(hourly.temperature)
            time.append(hourly.time)
            humidity.append(hourly.humidity)
            chance_rain.append(hourly.chances_of_rain)
            cloud_coverage.append(hourly.cloud_cover)
            # heat_index.append(hourly.heat_index)
        
        # Save data to dataframe
        d = {
            'temp': temp,
            'time': time,
            'humidity': humidity,
            'chance_rain': chance_rain,
            'cloud_coverage': cloud_coverage
            # 'heat_index': heat_index
        }

        forecast_data = pd.DataFrame(data=d)
        forecast_data.to_csv(forecast_csv)


if __name__ == '__main__':
  # see https://stackoverflow.com/questions/45600579/asyncio-event-loop-is-closed-when-getting-loop
  # for more details

 # if os.name == 'nt':
 #   asyncio.set_event_loop_policy(asyncio.WindowsSelectorEventLoopPolicy())

	asyncio.run(getweather())

