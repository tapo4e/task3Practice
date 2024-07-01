package com.example.mbanking.util

fun checkCompany(company: String, validError: Boolean = false): Boolean {
    return if (validError) !Regex("^[A-Z]+[a-z]*+(-)*[a-z]+$").matches(company) else false
}

fun checkAmount(amount: String, validError: Boolean = false): Boolean {
    return if (validError) !Regex("^[0-9]+\\.?[0-9]*$").matches(amount) else false
}

fun checkDate(date: String, validError: Boolean = false): Boolean {
    return if (validError) date == "" else false
}

fun checkStatus(status: String, validError: Boolean = false): Boolean {
    return if (validError) !(status == "Executed" || status == "In progress" || status == "Declined") else false
}

fun checkNumber(number: String, validError: Boolean = false): Boolean {
    return if (validError) !Regex("[A-Za-z0-9]{16}").matches(number) else false
}

fun resultCheck(
    company: String,
    amount: String,
    date: String,
    status: String,
    number: String,
): Boolean {
    return (Regex("^[A-Z]+[a-z]*(-)*[a-z]+$").matches(company) &&
            Regex("^[0-9]+\\.?[0-9]*$").matches(amount) &&
            date != "" &&
            (status == "Executed" || status == "In progress" || status == "Declined") &&
            Regex("[A-Za-z0-9]{16}").matches(number))
}
