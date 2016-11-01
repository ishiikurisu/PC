void setup() {
	Serial.begin(9600);
	Serial.flush();
}

/*
int readInt() {
	int value;
	byte junk;

	while (Serial.available == 0);
	value = Serial.parseInt();
	while (Serial.available != 0)
		junk = Serial.read();

	return value;
}
*/

int* readManyInt() {
	int* value = (int*) malloc(sizeof(int));
	int size = 1;
	byte junk;

	while (Serial.available() == 0);

	while (Serial.available() > 0) {
		value[size-1] = Serial.parseInt();
		value = (int*) realloc(value, size + 1);
		size++;
	}
	junk = Serial.read();

	return value;

}

int* readData() {
	int* sequence = readManyInt();
	return sequence;
}

void writeData(int sequence[]) {
	int i = 0;

	for (i = 1; i <= sequence[0]; i++) {
		Serial.print(sequence[i]);
		Serial.print(" ");
	}
	Serial.println(" ");
}

void loop() {
	int* sequence = readData();
	writeData(sequence);
}
