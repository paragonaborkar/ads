import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'friendlyLabel'

})
export class FriendlyLabelPipePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    var str = value.replace(/([A-Z])/g, function($1){return " "+$1;});

    return str.charAt(0).toUpperCase() + str.slice(1);
  }

}
