import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'friendlyLabel'

})
export class FriendlyLabelPipePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    var str = value.replace(/([A-Z])/g, function($1){return " "+$1;});
    return str.charAt(0).toUpperCase() + str.slice(1);
  }

  // transform(str: any, args?: any): any {
  //   var res = str.charAt(0);
  //   var newStr = '';

  //   if (res == res.toUpperCase()) {
  //     newStr = str;
  //   }

  //   var arr = str.split('');
  //   for (var i = 0; i < arr.length - 1; i++) {
  //     if ((arr[i] == arr[i].toUpperCase()) && arr[i + 1] == arr[i + 1].toUpperCase()) {
  //       newStr = str;
  //     }
  //   }

  //   if (res == res.toLowerCase()) {
  //     var noAdjCaps = true;
  //     for (var i = 0; i < arr.length - 1; i++) {
  //       if ((arr[i] == arr[i].toUpperCase()) && arr[i + 1] == arr[i + 1].toUpperCase()) {
  //         noAdjCaps = false;
  //       }
  //     }

  //     if (noAdjCaps) {
  //       newStr = str.replace(/([A-Z])/g, ' $1').replace(/^./, function (str) { return str.toUpperCase(); });
  //     }
  //   }

  //   return newStr;
  // }
}
