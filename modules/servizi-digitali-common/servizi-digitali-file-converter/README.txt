Il funzionamento del converter  wkhtmltopdf deve prevedere:
1) l'aggiunta del codice JS:

Function.prototype.bind = Function.prototype.bind || function (thisp) {
  var fn = this;
  return function () {
    return fn.apply(thisp, arguments);
  };
};

all'inizio di tutte le funzioni Jacascript presenti nell'HTML da cui generare il PDF
2) l'aggiunta del codice JS:

window.status = 'ready_to_print';

alla fine dell'esecuzione di tutto il codice JS presente nell'HTML da cui generare il PDF