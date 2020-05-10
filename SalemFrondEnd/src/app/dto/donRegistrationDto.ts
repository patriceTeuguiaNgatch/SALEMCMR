export class DonMaterialRegistrationDto {
    private firstName: string;
    private lastName: string;
    private email: string;
    private roadNumber: string;
    private town: string;
    private zipCode: string;
    private phoneNumber: string;
    private country: string;
    private kind: string;
    private comment: string
    private isConfidential: boolean;
    private edon = "material";

    setFirstName(firstName: string) {
        this.firstName = firstName;
    }

    setLastName(lasttName: string) {
        this.lastName = lasttName;
    }

    setEmail(email: string) {
        this.email = email;
    }

    getEmail() {
        return this.email;
    }

    setRoadNumber(roadNumber: string) {
        this.roadNumber = roadNumber;
    }

    setTown(town: string) {
        this.town = town;
    }
    setZipCode(zipCode: string) {
        this.zipCode = zipCode;
    }
    setCountry(country: string) {
        this.country = country;
    }
    setkind(kind: string) {
        this.kind = kind;
    }

    setEdon(edon: string) {
        this.edon = edon;
    }

    setComment(comment: string) {
        this.comment = comment;
    }
    setIsConfidential(isConfidential: boolean) {
        this.isConfidential = isConfidential;
    }

    setPhoneNumber(phoneNumber: string) {
        this.phoneNumber = phoneNumber;
    }

}