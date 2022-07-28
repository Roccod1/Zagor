module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    clean: ['dist', 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs'],
    concat: {
      options: {
        separator: ';'
      },
      dist: {
        src: [
              'alpaca/customfields/**/*.js',
              '!alpaca/customfields/**/_*.js',
              '!alpaca/customfields/**/_*.txt',
        ],
        dest: 'alpaca/dist/custom-fields.js'
      }
    },
    copy: {
		libs: {
			files: [
				{
					expand: true,
					cwd: 'alpaca/commonlibs',
					src: '**/*',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs'
				},
				{
					expand: true,
					cwd: 'node_modules/select2/dist',
					src: '**/*',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/select2'
				},
				{
					expand: true,
					cwd: 'node_modules/fullcalendar/dist',
					src: '**/*',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/fullcalendar'
				},
				{
					expand: true,
					cwd: 'node_modules/jquery-ui-dist/',
					src: 'jquery-ui.min.js',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/jquery-ui-dist'
				},
				{
					expand: true,
					cwd: 'node_modules/handlebars/dist',
					src: '**/*',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/handlebars'
				},
				{
					expand: true,
					cwd: 'node_modules/jquery-blockui/',
					src: 'jquery.blockUI.js',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/jquery-blockui'
				},
				{
					expand: true,
					cwd: 'node_modules/jquery-file-download/src/Scripts',
					src: 'jquery.fileDownload.js',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/jquery-filedownload'
				},
				{
					expand: true,
					cwd: 'node_modules/moment/min',
					src: '**/*',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/moment'					
				},
				{
					expand: true,
					cwd: 'node_modules/pdfjs-dist/build',
					src: '**/*',
					dest: 'modules/presentatore-forms/presentatore-forms-frontend/src/main/resources/META-INF/resources/libs/pdfjs-dist'					
				}
			]
		}
	},
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy HH:MM:ss") %> */\n'
      },
      dist: {
        files: {
          'alpaca/dist/custom-fields.min.js': ['<%= concat.dist.dest %>']
        }
      }
    },
    jshint: {
      files: ['Gruntfile.js', 'alpaca/customfields/**/*.js'],
      options: {
        // options here to override JSHint defaults
      }
    },
    watch: {
      files: ['<%= jshint.files %>'],
      tasks: ['jshint']
    }
  });

  grunt.file.setBase('../../../');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-replace');

  grunt.registerTask('test', ['jshint']);

  grunt.registerTask('default', [/*'jshint', */'clean', 'concat', 'copy', 'uglify']);
};