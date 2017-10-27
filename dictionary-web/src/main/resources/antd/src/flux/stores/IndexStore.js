import Alt from 'bases/Alt.js';
import IndexAction from 'actions/IndexAction.js';

class DictStore {

  constructor(){
    this.bindListeners({
      handleDictSearch: IndexAction.dictSearch,
      handleTranslate: IndexAction.translate
    });
    this.state={
      word: null,
      translate: null
    }
  }

  handleDictSearch = (word) => {
    if (word) {

    }
  }

  handleTranslate = (content) => {
    if (content) {

    }
  }
}

export default Alt.createStore(DictStore, 'DictStore');
