import Alt from 'bases/Alt.js';

class IndexAction {

  dictSearch(word) {
    return word;
  }

  translate(content) {
    return content;
  }

}

export default Alt.createActions(IndexAction);
