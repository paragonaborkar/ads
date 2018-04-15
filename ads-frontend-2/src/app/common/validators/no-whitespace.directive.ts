import { Directive, Input, OnChanges, SimpleChanges } from '@angular/core';
import { NoWhitespaceValidator } from './no-whitespace.validator';
import { Validator, AbstractControl, Validators, NG_VALIDATORS } from '@angular/forms';

/**
 * This validator works like "required" but it does not allow whitespace either
 *
 * @export
 * @class NoWhitespaceDirective
 * @implements {Validator}
 */
@Directive({
	selector: '[adsNoSpaces]',
	providers: [{ provide: NG_VALIDATORS, useExisting: NoWhitespaceDirective, multi: true }]
})
export class NoWhitespaceDirective implements Validator {

	private valFn = NoWhitespaceValidator();
	validate(control: AbstractControl): { [key: string]: any } {
		return this.valFn(control);
	}
}
