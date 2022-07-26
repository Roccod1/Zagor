module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    clean: ['dist', 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs'],
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
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs'
				},
				{
					expand: true,
					cwd: 'node_modules/select2/dist',
					src: '**/*',
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/select2'
				},
				{
					expand: true,
					cwd: 'node_modules/jquery-ui/',
					src: [
						'ui/**/*',
						'themes/**/*'
					],
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/jquery-ui'
				},
				{
					expand: true,
					cwd: 'node_modules/leaflet/dist',
					src: '**/*',
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/leaflet'
				},
				{
					expand: true,
					cwd: 'node_modules/jquery-validation/dist',
					src: '**/*',
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/jquery-validation'
				},
				{
					expand: true,
					cwd: 'node_modules/typeahead.js/dist',
					src: '**/*',
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/typeahead.js'
				},
				{
					expand: true,
					cwd: 'node_modules/datatables.net/js',
					src: '**/*',
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/datatables.net'
				},
				{
					expand: true,
					cwd: 'node_modules/datatables.net-rowreorder/js',
					src: '**/*',
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/datatables.net'
				},
				{
					expand: true,
					cwd: 'node_modules/ckeditor4',
					src: 'ckeditor.js',
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/ckeditor4'
				},
				{
					expand: true,
					cwd: 'node_modules/blueimp-file-upload',
					src: [
						'css/**',
						'js/**',
						'img/**'
					],
					dest: 'modules/gestione-forms/gestione-forms-frontend/src/main/resources/META-INF/resources/libs/blueimp-file-upload'
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