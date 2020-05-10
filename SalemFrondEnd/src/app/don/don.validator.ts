import { FormControl } from '@angular/forms';
export class DonValidator {
    static currencyValidator(fc: FormControl) {
        if (fc.value === "Choississez la devise") {
            return ({ currencyValidator: true });
        } else {
            return (null);
        }
    }
}