import React,{Component} from 'react';
import connectToStores from 'alt-utils/lib/connectToStores';
import IndexAction from 'actions/IndexAction.js';
import IndexStore from 'stores/IndexStore.js';

class trans extends Component {

  static getStores(){
    return [IndexStore]
  }

  static getPropsFromStores(){
    let state = IndexStore.getState();
    return {
      translate : state.translate
    }
  }

  render(){
    return (
        <div>
          <span>翻译</span>
          {this.props.translate}
        </div>
    )
  }
}

export default connectToStores(trans);
