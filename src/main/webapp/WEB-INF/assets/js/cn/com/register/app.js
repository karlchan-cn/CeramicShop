/*******************************************************************************
 * Application
 ******************************************************************************/
App = Em.Application.create( {
	mixmaster : 'Andy'
});

/*******************************************************************************
 * Models
 ******************************************************************************/
App.BLogEntity = Em.Object.extend( {
	url : null,
	title : null,
	cont : null,
	user : {
		username : null,
		createdate : null
	},
	category : [ {
		url : null,
		name : null
	} ],
	comment : {
		count : 0,
		url : null
	}
});

/*******************************************************************************
 * Views
 ******************************************************************************/
App.SearchTextField = Em.TextField.extend( {
	insertNewline : function() {
		// App.tweetsController.loadTweets();
	}
});

/*******************************************************************************
 * Controllers
 ******************************************************************************/
App.entitiesController = Em.ArrayController.create( {
	content : [],
	username : '',
	init : function() {
		for ( var i = 0; i < 2; i++) {
			var t = App.BLogEntity.create();
			t.set('url', 'test');
			t.set('title', 'title' + i);
			t.set('cont', 'content' + i);
			t.set('user', {
				username : 'username' + i,
				createdate : new Date()
			});
			t.set('category', {
				'url' : 'urlcate' + i,
				name : 'cate' + i
			});
			t.set('comment', {
				'count' : i,
				url : 'comment' + i
			});
			this.pushObject(t);
		}
	}
});

App.initialize();
