import serial, time
from firebase import firebase

firebase = firebase.FirebaseApplication('https://proyectoev-4-default-rtdb.firebaseio.com/')

arduino = serial.Serial('COM4', 9600)
time.sleep(2)

while True:
    dato = arduino.readline().decode('utf-8')
    data = {'dato': dato}
    result = firebase.put('datos/Temp', 'Temperatura', data)