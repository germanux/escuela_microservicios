import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } 
  from '@angular/platform-browser-dynamic';

import { AppModulo } from './app/app.modulo';
import { environment } from './environments/environment';
// public static void main() {

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModulo)
  .catch(err => console.error(err));

// }
