#include <jni.h>
#include <string>
#include <android/log.h>
#include <vector>
#include <algorithm>
#include <iostream>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_jnicalculator_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */,
        jstring number) {
    const char *message = env->GetStringUTFChars(number, nullptr);

    std::string hello = message;

    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnicalculator_MainActivity_calculateAdd(
        JNIEnv *env,
        jobject thiz,
        jstring number,
        jstring operador) {

    const char *number1 = env->GetStringUTFChars(number, nullptr);
    const char *number2 = env->GetStringUTFChars(operador, nullptr);

    std::string firstStr = number1;
    std::string secondStr = number2;

    int intNumberOne = std::stoi(firstStr);
    int intNumberTwo = std::stoi(secondStr);

    return intNumberOne + intNumberTwo;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnicalculator_MainActivity_calculateMinus(
        JNIEnv *env,
        jobject thiz,
        jstring number,
        jstring operador) {

    const char *number1 = env->GetStringUTFChars(number, nullptr);
    const char *number2 = env->GetStringUTFChars(operador, nullptr);

    std::string firstStr = number1;
    std::string secondStr = number2;

    int intNumberOne = std::stoi(firstStr);
    int intNumberTwo = std::stoi(secondStr);

    return intNumberOne - intNumberTwo;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnicalculator_MainActivity_calculateTimes(
        JNIEnv *env,
        jobject thiz,
        jstring number,
        jstring operador) {

    const char *number1 = env->GetStringUTFChars(number, nullptr);
    const char *number2 = env->GetStringUTFChars(operador, nullptr);

    std::string firstStr = number1;
    std::string secondStr = number2;

    int intNumberOne = std::stoi(firstStr);
    int intNumberTwo = std::stoi(secondStr);

    return intNumberOne * intNumberTwo;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_jnicalculator_MainActivity_calculateDivision(
        JNIEnv *env,
        jobject thiz,
        jstring number,
        jstring operador) {

    const char *number1 = env->GetStringUTFChars(number, nullptr);
    const char *number2 = env->GetStringUTFChars(operador, nullptr);

    std::string firstStr = number1;
    std::string secondStr = number2;

    double doubleNumberOne = std::stod(firstStr);
    double doubleNumberTwo = std::stod(secondStr);

    return doubleNumberOne / doubleNumberTwo;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnicalculator_MainActivity_calculateExponentiation(
        JNIEnv *env,
        jobject thiz,
        jstring number,
        jstring operador) {

    const char *number1 = env->GetStringUTFChars(number, nullptr);
    const char *number2 = env->GetStringUTFChars(operador, nullptr);

    std::string firstStr = number1;
    std::string secondStr = number2;

    int intNumberOne = std::stoi(firstStr);
    int intNumberTwo = std::stoi(secondStr);

    int count = intNumberOne;

    for (int i = 1;i < intNumberTwo; i++){
        count *= intNumberOne;
    }

    return count;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_jnicalculator_MainActivity_calculatePercentage(
        JNIEnv *env,
        jobject thiz,
        jstring number,
        jstring operador) {


    const char *number1 = env->GetStringUTFChars(number, nullptr);
    const char *number2 = env->GetStringUTFChars(operador, nullptr);

    std::string firstStr = number1;
    std::string secondStr = number2;

    double doubleNumberOne = std::stod(firstStr);
    double doubleNumberTwo = std::stod(secondStr);

    return doubleNumberOne * (doubleNumberTwo) / 100;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_jnicalculator_MainActivity_firstLogInCpp(
        JNIEnv *env,
        jobject thiz,
        jstring text) {
    const char *message = env->GetStringUTFChars(text, nullptr);

    __android_log_write(ANDROID_LOG_DEBUG, "Meu Log", message);

    env->ReleaseStringUTFChars(text, message);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_jnicalculator_MainActivity_concatenateNumbers(
        JNIEnv *env,
        jobject thiz,
        jstring current_number,
        jstring new_digit) {
    const char *currentStr = env->GetStringUTFChars(current_number, nullptr);
    const char *newDigitStr = env->GetStringUTFChars(new_digit, nullptr);

    std::string result = std::string(currentStr) + newDigitStr;

    env->ReleaseStringUTFChars(current_number, currentStr);
    env->ReleaseStringUTFChars(new_digit, newDigitStr);

    return env->NewStringUTF(result.c_str());
}