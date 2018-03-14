import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'yesNo'

})
export class YesNoPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    console.log("YesNoPipe:", value);
    return value ? 'Yes' : 'No';
  }

}
