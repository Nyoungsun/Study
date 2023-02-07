//1
int ledPin = 10;
void setup()
{
    pinMode(ledPin, OUTPUT);
}

void loop()
{
    digitalWrite(ledPin, HIGH);
    delay(1000);
    digitalWrite(ledPin, LOW);
    delay(1000);
}

//2
int ledPin = 10;
int button = 9;

void setup()
{
    pinMode(ledPin, OUTPUT);
}
void loop()
{
    int state = digitalRead(button);

    if (state == HIGH)
      digitalWrite(ledPin, HIGH);
    else
      digitalWrite(ledPin, LOW);
}

//3
int ledPin = 10;
int analogPin = 1;

void setup()
{
    pinMode(ledPin, OUTPUT);
    Serial.begin(9600);
}

void loop()
{
    float X;
    float C;

    X = analogRead(analogPin);
    C = (X * 5 /1024 - 0.5) * 100;

    if(C >= 25)
      digitalWrite(ledPin, HIGH);
    else
      digitalWrite(ledPin, LOW);
    delay(2000);
    Serial.println(C);
}