//1
int ledPin = 10;

void setup(){
  pinMode(ledPin, OUTPUT);
}
  
void loop(){
  fadeOn(1000);
  fadeOff(1000);
}

void fadeOn(unsigned int time) {
  for (byte value=0; value<255; value+=5){
    analogWrite(ledPin, value);
    delay(time/(255/5));
 }
}
void fadeOff(unsigned int time){
  for (byte value=255; value>0; value-=5){
    analogWrite(ledPin, value);
    delay(time/(255/5));
 }
}

//2
int ledPin = 10;
int scope = 5;
int interval = 1000;

void setup(){
  pinMode(ledPin, OUTPUT);
  pinMode(scope, OUTPUT);
  
  Serial.begin(9600);
  do{
  interval = Serial.parseInt();
  }while(interval==0);
 
  Serial.println(interval);
  Serial.println(ledPin);
}

void loop(){
  fadeOn(interval);
  fadeOff(interval);
}

void fadeOn(unsigned int time) {
  for (byte value=0; value<255; value+=5){
    analogWrite(ledPin, value);
    analogWrite(scope, value);
    delay(time/(255/5));
 }
}
void fadeOff(unsigned int time){
  for (byte value=255; value>0; value-=5){
    analogWrite(ledPin, value);
    analogWrite(scope, value);
    delay(time/(255/5));
 }
}

//3
int ledPin = 10;
int sensor = 3;
unsigned char state = 0;

void setup()
{
  pinMode(ledPin, OUTPUT);
  pinMode(sensor, INPUT);
  attachInterrupt(1, blink, RISING);
}

void loop()
{
  if(state!=0){
    state=0;
    digitalWrite(ledPin, HIGH);
    delay(500);
  }
  else{
  digitalWrite(ledPin, LOW);
  }
}

void blink(){
state ++;
}