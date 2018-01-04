package com.mun0n.kotlincontacts.presentation.model.UserModel

class UserModel {

    var firstName: String
    var lastName: String
    var urlPictureThumbnail: String
    var phone: String
    var gender: String
    var street: String
    var city: String
    var state: String
    var registerDate: String
    var email: String
    var urlPictureBig: String

    constructor(firstName: String, lastName: String, urlPictureThumbnail: String, phone: String, gender: String, street: String, city: String, state: String, registerDate: String, email: String, urlPictureBig: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.urlPictureThumbnail = urlPictureThumbnail
        this.phone = phone
        this.gender = gender
        this.street = street
        this.city = city
        this.state = state
        this.registerDate = registerDate
        this.email = email
        this.urlPictureBig = urlPictureBig
    }
}