import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DummyDataService {

  constructor() { }

  getDummyData() {

    return {
      "rows": [
        {
          "id": "1",
          "text1": "text 1.1",
          "text2": "text 1.2",
          "children": []
        },
        {
          "id": "2",
          "text1": "text 2.1",
          "text2": "text 2.2",
          "children": [
            {
              "id": "2.1",
              "text1": "text 2.1.1",
              "text2": "text 2.1.2",
              "children": [
                {
                  "id": "2.1.1",
                  "text1": "text 2.1.1.1",
                  "text2": "text 2.1.1.2",
                  "children": []
                }]
            }]
        },
        {
          "id": "4",
          "text1": "text 4.1",
          "text2": "text 4.2",
          "children": []
        }]
    }



  }


}
