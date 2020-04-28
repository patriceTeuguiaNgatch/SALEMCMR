export class RequestInformationDto {

    private firstName: string;
    private lastName: string;
    private email: string;
    private phoneNumber: string;
    private comment: string;

    setFirstName(firstName: string) {
        this.firstName = firstName;
    }

    setLastName(lasttName: string) {
        this.lastName = lasttName;
    }

    setPhoneNumber(phoneNumber: string) {
        this.phoneNumber = phoneNumber;
    }


    setEmail(email: string) {
        this.email = email;
    }

    getEmail() {
        return this.email;
    }

    setComment(comment: string) {
        this.comment = comment;
    }
}