export class AccountRegistrationDto {

    private firstName: string;
    private lastName: string;
    private password: string;
    private email: string;
    private phoneNumber: string;
    private role: string = "subscriber";

    setFirstName(firstName: string) {
        this.firstName = firstName;
    }

    setLastName(lasttName: string) {
        this.lastName = lasttName;
    }

    setPassword(password: string) {
        this.password = password;
    }

    setEmail(email: string) {
        this.email = email;
    }

    setPhoneNumber(phoneNumber: string) {
        this.phoneNumber = phoneNumber;
    }

}