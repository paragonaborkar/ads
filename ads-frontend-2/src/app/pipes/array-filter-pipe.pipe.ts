import { Pipe, PipeTransform } from '@angular/core';

import { ColumnConfig } from './column-config';

@Pipe({
  name: 'arrayFilter',
  pure: false
})
export class ArrayFilterPipePipe implements PipeTransform {

  transform(items: ColumnConfig[], filter: ColumnConfig): ColumnConfig[] {
    if (!items || !filter) {
      return items;
    }
    // filter items array, items which match and return true will be kept, false will be filtered out
    return items.filter((item: ColumnConfig) => this.applyFilter(item, filter));
  }

  /**
   * Perform the filtering.
   * 
   * @param {ColumnConfig} book The book to compare to the filter.
   * @param {ColumnConfig} filter The filter to apply.
   * @return {boolean} True if book satisfies filters, false if not.
   */
  applyFilter(book: ColumnConfig, filter: ColumnConfig): boolean {

    for (let field in filter) {
      if (typeof filter[field] === 'string') {
        if (book[field].toLowerCase().indexOf(filter[field].toLowerCase()) === -1) {
          return false;
        }
      } else if (typeof filter[field] === 'number') {
        if (book[field] !== filter[field]) {
          return false;
        }
      } else if (typeof filter[field] === 'boolean') {
        if (book[field] !== filter[field]) {
          return false;
        }
      }
      return true;
    }

  }
}