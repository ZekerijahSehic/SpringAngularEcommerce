import {FormControl, ValidationErrors} from "@angular/forms";

export class FormsValidator {

  static notOnlyWhiteSpace(control: FormControl) : ValidationErrors {

    if((control.value != null) && (control.value.trim().length === 0)) {
      return {'whiteSpaceError': true}
    } else {
      return null;
    }

  }
}
